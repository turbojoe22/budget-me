<template>
  <br>
  <div class="expense-form">
    <h2>Create Expense</h2>
    <form @submit.prevent="submitExpense">
      <div class="form-group">
        <label for="due_date">Due Date:</label>
        <input type="date" id="dueDate" v-model="expense.dueDate" required>
      </div>
      <div class="form-group">
        <label for="isRepeated">Is Repeated:</label>
        <input type="checkbox" id="isRepeated" v-model="expense.isRepeated">
      </div>
      <div class="form-group" v-if="expense.isRepeated">
        <label for="frequency">Frequency:</label>
        <select id="frequency" v-model="expense.frequency" required>
          <option value="">Select Frequency</option>
          <option value="bi-weekly">Bi-Weekly</option>
          <option value="weekly">Weekly</option>
          <option value="monthly">Monthly</option>
        </select>
      </div>
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="expenseName" v-model="expense.expenseName" required>
      </div>
      <div class="form-group">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" v-model="expense.amount" required>
      </div>
      <div class="form-group">
        <label for="tag">Tag:</label>
        <input type="text" id="tag" v-model="expense.tag" required>
      </div>
      <button type="submit" @click="submitExpense">Submit</button>
    </form>
  </div>

</template>

<style>

</style>

<script>
export default {

  data() {
    return {
      expense: {
        dueDate: '',
        isRepeated: false,
        frequency: '',
        expenseName: '',
        amount: null,
        tag: ''
      }
    };
  },
  methods: {
    async submitExpense() {

        if (this.expense.expenseName === null || this.expense.expenseAmount === null) {
            this.addStatus = "Try again: Name or $Amount blank"
            return;
        } else {
            const expenseAddRequest = {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(this.expense)
            };
            console.log(expenseAddRequest)
            const response = await fetch("/api/expenses/add", expenseAddRequest);
            console.log(response);

      }
    }
  }
}
</script>



