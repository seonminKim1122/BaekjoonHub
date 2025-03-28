-- 코드를 작성해주세요
SELECT T3.ITEM_ID, T3.ITEM_NAME, T3.RARITY
FROM ITEM_INFO T3
WHERE T3.ITEM_ID IN (
    SELECT T1.ITEM_ID
    FROM ITEM_TREE T1
        LEFT JOIN ITEM_TREE T2 ON T1.ITEM_ID = T2.PARENT_ITEM_ID
    WHERE T2.PARENT_ITEM_ID IS NULL
)
ORDER BY T3.ITEM_ID DESC;