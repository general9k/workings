package ru.ksanxxx.abitur.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.ksanxxx.abitur.controller.api.AbiturientControllerApi;
import ru.ksanxxx.abitur.model.Abiturient;
import ru.ksanxxx.abitur.model.Category;
import ru.ksanxxx.abitur.model.request.CreateAbiturientRequest;
import ru.ksanxxx.abitur.service.facade.AbiturientFacade;
import ru.ksanxxx.abitur.service.facade.AchievementFacade;
import ru.ksanxxx.abitur.service.facade.AddressFacade;
import ru.ksanxxx.abitur.service.facade.CategoryFacade;
import ru.ksanxxx.abitur.service.facade.EducationFacade;
import ru.ksanxxx.abitur.service.facade.SpecialtyFacade;
import ru.ksanxxx.abitur.service.facade.UserFacade;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AbiturientController implements AbiturientControllerApi {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private final UserFacade userFacade;

    private final AbiturientFacade abiturientFacade;

    private final EducationFacade educationFacade;

    private final SpecialtyFacade specialtyFacade;

    private final AchievementFacade achievementFacade;

    private final CategoryFacade categoryFacade;

    private final AddressFacade addressFacade;

    @Override
    public String getAbiturients(Model model, String categoryName, Boolean isAchievement, String sort) {
        List<Abiturient> abiturients = abiturientFacade.getAbiturients(categoryName, isAchievement, sort);
        List<Category> categories = categoryFacade.getAll();

        model.addAttribute("categories", categories);
        model.addAttribute("abiturients", abiturients);
        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        model.addAttribute("isOperator", userFacade.isOperator());
        model.addAttribute("isEditor", userFacade.isEditor());
        model.addAttribute("currentCategory", categoryName);
        model.addAttribute("currentSort", sort);
        model.addAttribute("currentIsAchievement", isAchievement);
        return "api/v1/abiturients";
    }

    @Override
    public void generateFilteredPdf(String categoryName, Boolean isAchievement, String sort, HttpServletResponse response) {
        try {
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=abiturients_filtered.pdf");

            List<Abiturient> abiturients = abiturientFacade.getAbiturients(categoryName, isAchievement, sort);

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            document.add(new Paragraph("Список абитуриентов", getRussianFont(16, Font.BOLD)));

            document.add(new Paragraph(String.format("Фильтры: Категория = %s, Инд. достижения = %s, Сортировка = %s",
                    categoryName != null && !categoryName.isEmpty() ? categoryName : "Все",
                    isAchievement != null ? (isAchievement ? "Имеются" : "Не имеются") : "Все",
                    sort != null && !sort.isEmpty() ? getSortedParameters(sort) : "Не задана"
            ), getRussianFont(12, Font.NORMAL)));

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            addTableHeader(table, "Фамилия", "Имя", "Дата рождения", "Учебное заведение", "Специальность", "Сумма баллов");

            for (Abiturient abiturient : abiturients) {
                table.addCell(new Phrase(abiturient.getLastName(), getRussianFont(10, Font.NORMAL)));
                table.addCell(new Phrase(abiturient.getFirstName(), getRussianFont(10, Font.NORMAL)));
                table.addCell(new Phrase(abiturient.getDateOfBirth().format(DATE_FORMATTER), getRussianFont(10, Font.NORMAL)));
                table.addCell(new Phrase(abiturient.getEducation().getName() + "," +
                                         abiturient.getEducation().getNumber().toString() + "," + abiturient.getEducation().getCity(), getRussianFont(10, Font.NORMAL)));
                table.addCell(new Phrase(abiturient.getSpeciality().getName(), getRussianFont(10, Font.NORMAL)));
                table.addCell(new Phrase(abiturient.getPoints().toString(), getRussianFont(10, Font.NORMAL)));
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addTableHeader(PdfPTable table, String... headers) {
        for (String header : headers) {
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Phrase(header, getRussianFont(12, Font.BOLD)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
    }

    private static Font getRussianFont(int size, int style) {
        try {
            String fontPath = "static/fonts/arial.ttf"; // Укажите путь к шрифту
            BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            return new Font(baseFont, size, style);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки шрифта", e);
        }
    }

    private static String getSortedParameters(String paramSort) {
        switch (paramSort) {
            case "firstName":
                return "Фамилия";
            case "lastName":
                return "Имя";
            case "birthDate":
                return "Дата рождения";
        }
        return "";
    }

    @Override // GET
    public String createAbiturient(Model model) {
        model.addAttribute("educations", educationFacade.getAll());
        model.addAttribute("specialties", specialtyFacade.getAll());
        model.addAttribute("achievements", achievementFacade.getAll());
        model.addAttribute("categories", categoryFacade.getAll());

        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());
        return "/api/v1/abiturients/create";
    }

    @Override // POST
    public String createAbiturient(CreateAbiturientRequest request) {

        Abiturient abiturient = Abiturient.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .patronymic(request.getPatronymic())
                .dateOfBirth(request.getDateOfBirth().atStartOfDay(ZoneOffset.UTC).toOffsetDateTime())
                .dateOfEnd(request.getDateOfEnd().atStartOfDay(ZoneOffset.UTC).toOffsetDateTime())
                .phoneNumber(request.getPhoneNumber())
                .education(educationFacade.getById(request.getEducation()))
                .address(addressFacade.saveAddress(request.getAddress()))
                .achievement(achievementFacade.getById(request.getAchievement()))
                .speciality(specialtyFacade.getById(request.getSpecialty()))
                .category(categoryFacade.getById(request.getCategory()))
                .points(request.getPoints())
                .build();

        abiturientFacade.saveAbiturient(abiturient);

        return "redirect:/api/v1/abiturients";
    }

    @Override
    public String editAbiturient(Model model, Integer id) {
        Abiturient abiturient = abiturientFacade.getById(id);

        model.addAttribute("abiturient", abiturient);
        model.addAttribute("educations", educationFacade.getAll());
        model.addAttribute("specialties", specialtyFacade.getAll());
        model.addAttribute("achievements", achievementFacade.getAll());
        model.addAttribute("categories", categoryFacade.getAll());

        model.addAttribute("isAuthenticated", userFacade.isAuthenticated());
        model.addAttribute("isAdmin", userFacade.isAdmin());

        return "api/v1/abiturients/edit";
    }

    @Override
    public String editAbiturient(CreateAbiturientRequest request, Integer id) {

        Abiturient abiturient = abiturientFacade.getById(id);

        request.getAddress().setId(abiturient.getAddress().getId());

        abiturient.setLastName(request.getLastName());
        abiturient.setFirstName(request.getFirstName());
        abiturient.setPatronymic(request.getPatronymic());
        abiturient.setDateOfBirth(request.getDateOfBirth().atStartOfDay(ZoneOffset.UTC).toOffsetDateTime());
        abiturient.setDateOfEnd(request.getDateOfEnd().atStartOfDay(ZoneOffset.UTC).toOffsetDateTime());
        abiturient.setPhoneNumber(request.getPhoneNumber());
        abiturient.setEducation(educationFacade.getById(request.getEducation()));
        abiturient.setAddress(addressFacade.saveAddress(request.getAddress()));
        abiturient.setAchievement(achievementFacade.getById(request.getAchievement()));
        abiturient.setSpeciality(specialtyFacade.getById(request.getSpecialty()));
        abiturient.setCategory(categoryFacade.getById(request.getCategory()));
        abiturient.setPoints(request.getPoints());

        abiturientFacade.saveAbiturient(abiturient);

        return "redirect:/api/v1/abiturients";
    }

    @Override
    public String deleteAbiturient(Integer id) {
        abiturientFacade.deleteAbiturient(id);
        return "redirect:/api/v1/abiturients";
    }
}
