package com.atguigu.crud.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andJsalaryIsNull() {
            addCriterion("jsalary is null");
            return (Criteria) this;
        }

        public Criteria andJsalaryIsNotNull() {
            addCriterion("jsalary is not null");
            return (Criteria) this;
        }

        public Criteria andJsalaryEqualTo(BigDecimal value) {
            addCriterion("jsalary =", value, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryNotEqualTo(BigDecimal value) {
            addCriterion("jsalary <>", value, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryGreaterThan(BigDecimal value) {
            addCriterion("jsalary >", value, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jsalary >=", value, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryLessThan(BigDecimal value) {
            addCriterion("jsalary <", value, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jsalary <=", value, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryIn(List<BigDecimal> values) {
            addCriterion("jsalary in", values, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryNotIn(List<BigDecimal> values) {
            addCriterion("jsalary not in", values, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jsalary between", value1, value2, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJsalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jsalary not between", value1, value2, "jsalary");
            return (Criteria) this;
        }

        public Criteria andJbonusIsNull() {
            addCriterion("jbonus is null");
            return (Criteria) this;
        }

        public Criteria andJbonusIsNotNull() {
            addCriterion("jbonus is not null");
            return (Criteria) this;
        }

        public Criteria andJbonusEqualTo(BigDecimal value) {
            addCriterion("jbonus =", value, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusNotEqualTo(BigDecimal value) {
            addCriterion("jbonus <>", value, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusGreaterThan(BigDecimal value) {
            addCriterion("jbonus >", value, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jbonus >=", value, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusLessThan(BigDecimal value) {
            addCriterion("jbonus <", value, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jbonus <=", value, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusIn(List<BigDecimal> values) {
            addCriterion("jbonus in", values, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusNotIn(List<BigDecimal> values) {
            addCriterion("jbonus not in", values, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jbonus between", value1, value2, "jbonus");
            return (Criteria) this;
        }

        public Criteria andJbonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jbonus not between", value1, value2, "jbonus");
            return (Criteria) this;
        }

        public Criteria andIsgrantIsNull() {
            addCriterion("isgrant is null");
            return (Criteria) this;
        }

        public Criteria andIsgrantIsNotNull() {
            addCriterion("isgrant is not null");
            return (Criteria) this;
        }

        public Criteria andIsgrantEqualTo(String value) {
            addCriterion("isgrant =", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantNotEqualTo(String value) {
            addCriterion("isgrant <>", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantGreaterThan(String value) {
            addCriterion("isgrant >", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantGreaterThanOrEqualTo(String value) {
            addCriterion("isgrant >=", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantLessThan(String value) {
            addCriterion("isgrant <", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantLessThanOrEqualTo(String value) {
            addCriterion("isgrant <=", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantLike(String value) {
            addCriterion("isgrant like", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantNotLike(String value) {
            addCriterion("isgrant not like", value, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantIn(List<String> values) {
            addCriterion("isgrant in", values, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantNotIn(List<String> values) {
            addCriterion("isgrant not in", values, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantBetween(String value1, String value2) {
            addCriterion("isgrant between", value1, value2, "isgrant");
            return (Criteria) this;
        }

        public Criteria andIsgrantNotBetween(String value1, String value2) {
            addCriterion("isgrant not between", value1, value2, "isgrant");
            return (Criteria) this;
        }

        public Criteria andGrantdateIsNull() {
            addCriterion("grantdate is null");
            return (Criteria) this;
        }

        public Criteria andGrantdateIsNotNull() {
            addCriterion("grantdate is not null");
            return (Criteria) this;
        }

        public Criteria andGrantdateEqualTo(Date value) {
            addCriterion("grantdate =", value, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateNotEqualTo(Date value) {
            addCriterion("grantdate <>", value, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateGreaterThan(Date value) {
            addCriterion("grantdate >", value, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateGreaterThanOrEqualTo(Date value) {
            addCriterion("grantdate >=", value, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateLessThan(Date value) {
            addCriterion("grantdate <", value, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateLessThanOrEqualTo(Date value) {
            addCriterion("grantdate <=", value, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateIn(List<Date> values) {
            addCriterion("grantdate in", values, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateNotIn(List<Date> values) {
            addCriterion("grantdate not in", values, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateBetween(Date value1, Date value2) {
            addCriterion("grantdate between", value1, value2, "grantdate");
            return (Criteria) this;
        }

        public Criteria andGrantdateNotBetween(Date value1, Date value2) {
            addCriterion("grantdate not between", value1, value2, "grantdate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}