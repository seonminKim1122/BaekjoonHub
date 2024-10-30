with test as (
    select count(*) as FISH_COUNT, f2.fish_name as FISH_NAME
    from fish_info as f1
        join fish_name_info as f2
            on f1.fish_type = f2.fish_type
    group by f2.fish_name
)
SELECT FISH_COUNT, FISH_NAME
FROM test
ORDER BY FISH_COUNT DESC;