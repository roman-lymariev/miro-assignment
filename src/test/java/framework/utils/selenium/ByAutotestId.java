package framework.utils.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ByAutotestId extends By {
    private final String dataAutomationId;

    public ByAutotestId(String dataAutomationId) {
        this.dataAutomationId = dataAutomationId;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        List<WebElement> mockElements = context.findElements(By.xpath("//*[@data-autotest-id='" + dataAutomationId + "']"));
        return mockElements;
    }
}
