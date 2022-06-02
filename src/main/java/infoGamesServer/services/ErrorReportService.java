package infoGamesServer.services;

import infoGamesServer.models.ErrorReport;

import java.util.List;

public interface ErrorReportService {
    public boolean createErrorReport(ErrorReport report);
    public List<ErrorReport>  getErrorReports(String token);
}
