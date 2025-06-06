-- 코드를 작성해주세요
SELECT T1.ID,
    CASE WHEN T1.PER <= 0.25 THEN "CRITICAL"
        WHEN T1.PER <= 0.5 THEN "HIGH"
        WHEN T1.PER <= 0.75 THEN "MEDIUM"
        ELSE "LOW" END AS "COLONY_NAME"
FROM (
    SELECT *, PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS "PER"
    FROM ECOLI_DATA
) T1
ORDER BY T1.ID;
