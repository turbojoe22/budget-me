<template>
  <br>
  <div>
    <h2>Expense List</h2>
    <button @click="getExpense">Display Expenses</button>
  </div>
  <table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Frequency</th>
            <th>Due Date</th>
            <th>Category</th>
        </tr>
    </thead>
    <tbody>
        <tr v-for="expense in expenses" :key="expense.expenseId">
            <td>{{expense.expenseName}}</td>
            <td>{{expense.amount}}</td>
            <td>{{expense.frequency}}</td>
            <td>{{expense.dueDate}}</td>
            <td>{{expense.category}}</td>
        </tr>
    </tbody>
  </table>


  <router-link to="/expenses/create" custom v-slot="{ navigate }"><button @click="navigate" role="link">Create an Expense</button></router-link>



</template>

<style>

</style>

<script>



    export default {
        data() {
            return {
                expenses: null,
            }
        },

        methods: {
            async getExpense() { const response = await fetch("/api/expenses/expenses" );
            this.expenses = await response.json();
            }
        },
    }
</script>



