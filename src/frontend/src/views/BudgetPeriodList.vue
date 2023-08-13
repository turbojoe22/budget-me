<template>
  <div id="page">
    <h1>Budget Period List</h1>
    <router-link to="/create-budget-period">
      <button class="margin-bottom"> Create</button>
    </router-link>

    <!-- Display the list of budget periods -->

    <ul class="budget-period-list">
      <li class="budget-period-item" v-for="budgetPeriod in budgetPeriods" :key="budgetPeriod.id">

      <div class="period-info">
     <span class="period-date"> Start Date: {{ budgetPeriod.startDate }}</span>
        <span class="period-date">End Date: {{ budgetPeriod.endDate }}</span>
       </div>

      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      budgetPeriods: [], // Store the list of budget periods
    };
  },
  created() {
    this.fetchBudgetPeriods();
  },
  methods: {
    async fetchBudgetPeriods() {
      try {
        const response = await fetch('/api/budget-period-list');
        if (response.ok) {
          this.budgetPeriods = await response.json();
        } else {
          console.error('Error fetching budget periods');
        }
      } catch (error) {
        console.error('Error fetching budget periods', error);
      }
    },
  },
};
</script>

<style>

.budget-period-list {
  list-style: none;
  padding: 0;
}

.budget-period-item {
  margin-bottom: 20px;
  padding: 10px;
  background-color: #f5f5f5;
  border-radius: 5px;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
}

.period-info {
  display: flex;
  flex-direction: column;
}

.period-date {
  font-weight: bold;
  margin-bottom: 5px;
}
.margin-bottom{
    margin-bottom: 40px;

}
</style>