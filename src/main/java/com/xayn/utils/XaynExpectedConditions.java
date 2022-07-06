package com.xayn.utils;

import com.xayn.handlers.AppiumHandler;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class XaynExpectedConditions {

    private XaynExpectedConditions() {
    }

    public static ExpectedCondition steadinessOfElementLocated(final By locator) {
        return new ExpectedCondition() {
            MobileElement element = null;
            Point location = null;


            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                if (element == null && driver != null) {
                    try {
                        element = driver.findElement(locator);
                    } catch (NoSuchElementException e) {
                        return null;
                    }
                }
                try {
                    if (element.isDisplayed()) {
                        Point locationPoint = element.getLocation();
                        if (locationPoint.equals(location)) {
                            return element;
                        }
                        location = locationPoint;
                    }
                } catch (StaleElementReferenceException e) {
                    element = null;
                }
                return null;
            }

            @Override
            public String toString() {
                return "steadiness of element located by " + locator;
            }
        };
    }

    public static ExpectedCondition<MobileElement> steadinessOfElementLocated(final MobileElement element) {
        return new ExpectedCondition() {
            private Point location = null;

            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    if (element.isDisplayed()) {
                        Point locationPoint = element.getLocation();
                        if (locationPoint.equals(location)) {
                            return element;
                        }
                        location = locationPoint;
                    }
                } catch (StaleElementReferenceException ignore) {
                }
                return null;
            }

            @Override
            public String toString() {
                return "steadiness of element " + element;
            }
        };
    }

    public static ExpectedCondition<MobileElement> elementToBeLocated(final MobileElement element) {
        return new ExpectedCondition() {
            private Point location = null;

            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    element.getLocation();
                } catch (java.util.NoSuchElementException ignore) {
                    return null;
                }
                return element;
            }

            @Override
            public String toString() {
                return "element in location " + element;
            }
        };
    }

    public static ExpectedCondition<MobileElement> elementOfListToExist(List<MobileElement> list, int index) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    if (list.size() > index) {
                        return list.get(index);
                    }
                } catch (Exception e) {
                    return null;
                }
                return null;
            }

            @Override
            public String toString() {
                return "list element with" + index + " index to be exist";
            }
        };
    }


    public static ExpectedCondition<MobileElement> attributeToChange(MobileElement element, String attribute, String attributeBefore) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                if (!element.getAttribute(attribute).equals(attributeBefore)) {
                    return element;
                }
                return null;
            }

            @Override
            public String toString() {
                return "attribute To Change from : " + attributeBefore + " to : " + attribute + " element : " + element;
            }
        };
    }

    public static ExpectedCondition<MobileElement> oneOfElementsContainAttribute(List<MobileElement> elements, String attribute, String value) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                for (MobileElement element : elements) {
                    try {
                        if (element.getAttribute(attribute).contains(value)) {
                            return element;
                        }
                    } catch (Exception ignore) {
                        return null;
                    }
                }
                return null;
            }

            @Override
            public String toString() {
                return "one Of Elements Contain Attribute attribute : " + attribute + " value : " + value + " element : " + elements.get(0);
            }
        };
    }

    public static ExpectedCondition<MobileElement> attributeChangeTo(MobileElement element, String attribute, String value) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                if (element.getAttribute(attribute).equals(value)) {
                    return element;
                }
                return null;
            }

            @Override
            public String toString() {
                return attribute + " attribute To Change to : " + value + " element : " + element;
            }
        };
    }


    public static ExpectedCondition<MobileElement> elementToBePresent(By by) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    AppiumHandler.getDriver().findElement(by).isDisplayed();
                } catch (NoSuchElementException | StaleElementReferenceException ignore) {
                    return null;
                }
                return (MobileElement) AppiumHandler.getDriver().findElement(by);
            }

            @Override
            public String toString() {
                return "element To Be Present : " + by;
            }
        };
    }

    public static ExpectedCondition<MobileElement> elementToBePresent(MobileElement element) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    element.isDisplayed();
                } catch (NoSuchElementException | StaleElementReferenceException ignore) {
                    return null;
                }
                return element;
            }

            @Override
            public String toString() {
                return "element To Be Present : " + element;
            }
        };
    }

    public static ExpectedCondition<MobileElement> elementNotPresent(MobileElement element) {
        return new ExpectedCondition() {
            @Override
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    element.isDisplayed();
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    return element;
                }
                return null;
            }

            @Override
            public String toString() {
                return "element To not Present : " + element;
            }
        };
    }


    public static ExpectedCondition<MobileElement> visibilityOf(MobileElement element) {
        return new ExpectedCondition() {
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                try {
                    return element.isDisplayed() ? element : null;
                } catch (Exception e) {
                    return null;
                }
            }

            public String toString() {
                return "visibility of " + element;
            }
        };
    }


    public static ExpectedCondition<MobileElement> elementToBeClickable(MobileElement element) {
        return new ExpectedCondition() {
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                MobileElement visibleElement = (MobileElement) ExpectedConditions.visibilityOf(element).apply(driver);

                try {
                    return visibleElement != null && visibleElement.isEnabled() ? visibleElement : null;
                } catch (StaleElementReferenceException var4) {
                    return null;
                }
            }

            public String toString() {
                return "element to be clickable: " + element;
            }
        };
    }

    public static ExpectedCondition<MobileElement> listOfElementsToBeClickable(List<MobileElement> elements, int index) {
        return new ExpectedCondition() {
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                MobileElement element;
                try {
                    element = elements.get(index);
                } catch (Exception e) {
                    return null;
                }
                MobileElement visibleElement = (MobileElement) ExpectedConditions.visibilityOf(element).apply(driver);
                try {
                    return visibleElement != null && visibleElement.isEnabled() ? visibleElement : null;
                } catch (StaleElementReferenceException var4) {
                    return null;
                }
            }

            public String toString() {
                return "element to be clickable: " + elements;
            }
        };
    }

    public static ExpectedCondition<MobileElement> listOfElementsToBeVisible(List<MobileElement> elements, int index) {
        return new ExpectedCondition() {
            public MobileElement apply(Object o) {
                WebDriver driver = (WebDriver) o;
                MobileElement element;
                try {
                    element = elements.get(index);
                } catch (Exception e) {
                    return null;
                }
                MobileElement visibleElement = (MobileElement) ExpectedConditions.visibilityOf(element).apply(driver);
                try {
                    return visibleElement != null && visibleElement.isDisplayed() ? visibleElement : null;
                } catch (StaleElementReferenceException var4) {
                    return null;
                }
            }

            public String toString() {
                return "element to be clickable: " + elements;
            }
        };
    }
}
