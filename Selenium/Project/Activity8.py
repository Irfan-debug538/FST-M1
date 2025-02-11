from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/crm")
    driver.maximize_window()
    action = ActionChains(driver)
    wait = WebDriverWait(driver, 10)

    user_name_input = driver.find_element(By.ID, "user_name")
    password_input = driver.find_element(By.ID, "username_password")
    login_button = driver.find_element(By.ID, "bigbutton")
    user_name_input.send_keys("admin")
    password_input.send_keys("pa$$w0rd")
    login_button.click()
    time.sleep(5)
    actions_button_home_page = driver.find_element(By.ID, "tab-actions")
    wait.until(EC.visibility_of(actions_button_home_page))

    sales_menu_item = driver.find_element(By.XPATH, "//a[text() = 'Sales']")
    accounts = driver.find_element(By.XPATH, "//a[text() = 'Accounts']")
    action.move_to_element(sales_menu_item).pause(3).click(accounts).perform()

    wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, ".table-responsive")))
    time.sleep(5)

    for i in range(1,10,2):
        rows_xpath_text = f"//div[@class= 'list-view-rounded-corners']/table/tbody/tr[{i}]"
        row = driver.find_elements(By.XPATH, rows_xpath_text)
        for col in row:
            col = driver.find_element(By.XPATH, f"{rows_xpath_text}/td[@field = 'name']//a")
            print(f"Name of account {i}: {col.text}")