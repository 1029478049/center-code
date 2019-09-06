-- 查询表结构
SELECT t1.Table_Name AS "表名称",
t3.comments AS "表说明",
t1.Column_Name AS "字段名称",
t1.Data_Type AS "数据类型",
t1.Data_Length AS "长度",
t1.NullAble AS "是否为空",
t2.Comments AS "字段说明",
t1.Data_Default "默认值"
FROM cols t1 left join user_col_comments t2
on t1.Table_name=t2.Table_name and t1.Column_Name=t2.Column_Name
left join user_tab_comments t3
on t1.Table_name=t3.Table_name
WHERE T1.Table_Name = 'DEPT'
ORDER BY t1.Table_Name, t1.Column_ID;