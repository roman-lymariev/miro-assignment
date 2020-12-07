package framework.utils.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ByPluginId extends By {
    private final String dataPluginId;

    public ByPluginId(String dataPluginId) {
        this.dataPluginId = dataPluginId;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        List<WebElement> mockElements = context.findElements(By.xpath("//*[@data-plugin-id='" + dataPluginId + "']"));
        return mockElements;
    }
}