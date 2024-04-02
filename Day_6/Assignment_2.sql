USE HR_DB
-- ANSWER 1 --
SELECT last_name, E.department_id, department_name
FROM EMPLOYEES E 
JOIN DEPARTMENTS D ON E.department_id = D.department_id;

-- ANSWER 2 --
SELECT DISTINCT E.job_id, D.location_id
FROM JOBS J RIGHT JOIN EMPLOYEES E ON J.job_id = E.job_id
LEFT JOIN DEPARTMENTS D ON E.department_id = D.department_id
WHERE E.department_id = 30;

-- ANSWER 3 --
SELECT E.last_name, D.department_name, D.location_id, L.city
FROM EMPLOYEES E
JOIN DEPARTMENTS D ON E.department_id = D.department_id
JOIN LOCATIONS L ON D.location_id = L.location_id
WHERE E.commission_pct IS NOT NULL;

-- ANSWER 4 --
SELECT E.last_name, D.department_name
FROM EMPLOYEES E
JOIN DEPARTMENTS D ON E.department_id = D.department_id
WHERE E.last_name LIKE '%a%';

-- ANSWER 5 (NOT WORKING) --
SELECT E.last_name, J.job_title, E.department_id, D.department_name
FROM EMPLOYEES E
LEFT JOIN DEPARTMENTS D ON E.department_id = D.department_id
LEFT JOIN JOBS J ON E.job_id = J.job_id
LEFT JOIN LOCATIONS L ON D.location_id = L.location_id
WHERE L.city LIKE 'Toronto';

-- ANSWER 6 --
SELECT E.last_name AS 'Employee', E.employee_id AS 'Emp#', M.last_name as 'Manager', E.manager_id as 'Manager#'
FROM EMPLOYEES E
JOIN EMPLOYEES M ON E.manager_id = M.employee_id;

-- ANSWER 7 --
SELECT E.last_name AS 'Employee', E.employee_id AS 'Emp#', M.last_name as 'Manager', E.manager_id as 'Manager#'
FROM EMPLOYEES E
LEFT JOIN EMPLOYEES M ON E.manager_id = M.employee_id
ORDER BY E.employee_id ASC;

-- ANSWER 8 (UNATTEMPTED) --


-- ANSWER 9 (NOT WORKING)-- 
SELECT E.first_name, E.last_name, J.job_title, D.department_name, E.salary
FROM EMPLOYEES E
JOIN DEPARTMENTS D ON E.department_id = D.department_id
LEFT JOIN JOBS J ON E.job_id = J.job_id;

-- ANSWER 10 --
SELECT E.first_name, E.last_name, E.hire_date
FROM EMPLOYEES E WHERE E.hire_date > (SELECT MAX(hire_date) FROM EMPLOYEES WHERE first_name LIKE '%DAVID');

-- ANSWER 11 --
SELECT E.first_name, E.hire_date, MGR.first_name
FROM EMPLOYEES E 
JOIN EMPLOYEES MGR ON E.manager_id = MGR.employee_id
WHERE E.hire_date < (SELECT MAX(hire_date) FROM EMPLOYEES M WHERE M.employee_id = E.manager_id);

-- ANSWER 12--
SELECT MIN(salary), MAX(salary), SUM(salary), AVG(salary)
FROM EMPLOYEES;

-- ANSWER 13 --
SELECT job_id, MIN(salary), MAX(salary), SUM(salary), AVG(salary)
FROM EMPLOYEES
GROUP BY job_id;

-- ANSWER 14 --
SELECT job_id, COUNT(employee_id)
FROM EMPLOYEES
GROUP BY job_id;

-- ANSWER 15 --
SELECT COUNT(DISTINCT manager_id)
FROM EMPLOYEES;

-- ANSWER 16 --
