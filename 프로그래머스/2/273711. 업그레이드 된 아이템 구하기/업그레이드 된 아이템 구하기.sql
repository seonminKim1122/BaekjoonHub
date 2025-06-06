-- 코드를 작성해주세요
SELECT T3.ITEM_ID, T3.ITEM_NAME, T3.RARITY
FROM ITEM_INFO T3
WHERE ITEM_ID IN (
    SELECT T2.ITEM_ID
    FROM (
        SELECT ITEM_ID
        FROM ITEM_INFO
        WHERE RARITY = 'RARE'
    ) T1 JOIN ITEM_TREE T2 ON T1.ITEM_ID = T2.PARENT_ITEM_ID
)
ORDER BY T3.ITEM_ID DESC;