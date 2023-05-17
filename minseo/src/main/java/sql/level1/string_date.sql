-- 특정 옵션이 포함된 자동차 리스트 구하기
SELECT *
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC;

-- 자동차 대여 기록에서 장기/단기 대여 구분하기
SELECT HISTORY_ID,
       CAR_ID,
       DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
       DATE_FORMAT(END_DATE, '%Y-%m-%d')   AS END_DATE,
       CASE
           WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
           ELSE '단기 대여'
           END                             AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE '2022-09%'
ORDER BY HISTORY_ID DESC;