package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class IssuesPage {

    @FindBy(xpath = "//h2[.='Issues summary']")
    public SelenideElement issuesHeader;

    @FindBy(xpath = "//a[.='Add new issue']")
    public SelenideElement addNewIssueBtn;

    @FindBy(id = "issue_summary")
    public SelenideElement issueSummary;

    @FindBy(id = "issue_description")
    public SelenideElement issueDescription;

    @FindBy(id = "type-view")
    public SelenideElement issueTypeSelector;

    @FindBy(xpath = "//label[.='Bug']")
    public SelenideElement issueTypeBug;

    @FindBy(id = "issue_priority")
    public SelenideElement issuePrioritySelector;

    @FindBy(xpath = "//label[.='High']")
    public SelenideElement issuePriorityHigh;

    @FindBy(name = "commit")
    public SelenideElement issueSaveBtn;

    @FindBy(xpath = "//div[@class='card_message']")
    public SelenideElement cardName;

    public void checkIssuesPage () {
        issuesHeader.shouldBe(Condition.visible);
        addNewIssueBtn.shouldBe(Condition.visible);
    }

    public void clickAddNewIssue () {
        addNewIssueBtn.click();
    }

    public void setIssueTypeBug () {
        issueTypeSelector.click();
        issueTypeBug.click();
    }

    public void setIssuePriorityHigh () {
        issuePrioritySelector.click();
        issuePriorityHigh.click();
    }

    public void AddNewIssue (String issueName, String issueDesc) {
        issueSummary.click();
        issueSummary.sendKeys(issueName);

        issueDescription.click();
        issueDescription.sendKeys(issueDesc);
        setIssueTypeBug();
        setIssuePriorityHigh();
        issueSaveBtn.click();
    }

    public void checkIssueAdded (String issueName) {
        cardName.shouldBe(Condition.text(issueName));
    }

}
