-- 코드를 작성해주세요
SELECT T1.DEPT_ID, T2.DEPT_NAME_EN, T1.AVG_SAL
FROM (
    SELECT DEPT_ID, ROUND(AVG(SAL)) AS 'AVG_SAL'
    FROM HR_EMPLOYEES
    GROUP BY DEPT_ID
) T1 JOIN HR_DEPARTMENT T2 ON T1.DEPT_ID = T2.DEPT_ID
ORDER BY T1.AVG_SAL DESC;
