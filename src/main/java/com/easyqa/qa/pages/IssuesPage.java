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

    @FindBy(xpath = "//label[.='Low']")
    public SelenideElement issuePriorityLow;

    @FindBy(xpath = "//label[.='Medium']")
    public SelenideElement issuePriorityMedium;

    @FindBy(xpath = "//label[.='High']")
    public SelenideElement issuePriorityHigh;

    @FindBy(xpath = "//label[.='Critical']")
    public SelenideElement issuePriorityCritical;

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

    public void setIssuePriorityLow () {
        issuePrioritySelector.click();
        issuePriorityLow.click();
    }

    public void setIssuePriorityMedium () {
        issuePrioritySelector.click();
        issuePriorityMedium.click();
    }

    public void setIssuePriorityHigh () {
        issuePrioritySelector.click();
        issuePriorityHigh.click();
    }

    public void setIssuePriorityCritical () {
        issuePrioritySelector.click();
        issuePriorityCritical.click();
    }

    public void AddNewIssue (String issueName, String issueDesc, int issuePriority) {
        issueSummary.click();
        issueSummary.sendKeys(issueName);
        issueDescription.click();
        issueDescription.sendKeys(issueDesc);
        setIssueTypeBug();
        //setIssuePriorityHigh();
        setPriority(issuePriority);
        issueSaveBtn.click();
    }

    public void setPriority (int priority) {
        switch (priority) {
            case 1:
                setIssuePriorityLow();
                break;
            case 2:
                setIssuePriorityMedium();
                break;
            case 3:
                setIssuePriorityHigh();
                break;
            case 4:
                setIssuePriorityCritical();
                break;
        }
    }

    public void checkIssueAdded (String issueName) {
        cardName.shouldBe(Condition.text(issueName));
    }

}
