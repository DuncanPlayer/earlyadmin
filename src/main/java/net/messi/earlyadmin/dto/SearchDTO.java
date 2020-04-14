package net.messi.earlyadmin.dto;

import net.messi.earlyadmin.pojo.NideshopKeywords;
import net.messi.earlyadmin.pojo.NideshopKeywordsKey;
import net.messi.earlyadmin.pojo.NideshopSearchHistory;

import java.io.Serializable;
import java.util.List;

public class SearchDTO implements Serializable {

    private List<NideshopKeywords> hotKeywordList;

    private NideshopKeywordsKey defaultKeyword;

    private List<NideshopSearchHistory> historyKeywordList;

    public List<NideshopKeywords> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<NideshopKeywords> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }

    public NideshopKeywordsKey getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(NideshopKeywordsKey defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<NideshopSearchHistory> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<NideshopSearchHistory> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }
}
