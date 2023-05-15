package ru.croc.course.report;

import ru.croc.course.support.Model;
import ru.croc.course.support.ReferenceModel;
import ru.croc.course.support.ReferenceModelSet;

import java.util.function.Function;

public class TestReportProvider implements ReportProvider {

    @Override
    public Function<Model, String> getReportRenderFunction() {
        return (model -> "json{next" + model.getAttribute("next") + "}");
    }

    @Override
    public String getReport(Model model) {
        return ReportProvider.super.getReport(model);
    }

    @Override
    public ReportType getServicedReportType() {
        return ReportType.TEST;
    }

    @Override
    public ReferenceModel getReferenceModel() {
        ReferenceModel referenceModel = new ReferenceModelSet();
        referenceModel.addAttribute("next");
        return referenceModel;
    }
}
