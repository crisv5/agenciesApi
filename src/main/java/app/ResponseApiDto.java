package app;

import javax.xml.ws.Response;
import java.util.List;

public class ResponseApiDto {

    private Paging paging;
    private List<Agency> results;

    public ResponseApiDto() {
    }

    public ResponseApiDto(Paging paging, List<Agency> results) {
        this.paging = paging;
        this.results = results;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Agency> getResults() {
        return results;
    }

    public void setResults(List<Agency> results) {
        this.results = results;
    }


}
