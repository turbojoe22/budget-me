<template>
  <br>
  <div>
    <h2>Expense List</h2>
    <button @click="getExpenseList">Display Expenses</button>
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
        <div v-if=!isEdit>
            <tr v-for="expense in expenses" :key="expense.expenseId">
                <td>{{ expense.expenseName }}</td>
                <td>{{ expense.amount }}</td>
                <td>{{ expense.frequency }}</td>
                <td>{{ expense.dueDate }}</td>
                <td>{{ expense.category }}</td>
                <td>
                    <button @click="editToggle">Edit</button>
                </td>
                <td>
                    <button @click="deleteExpense(expense.expenseId)">Delete</button>
                </td>
            </tr>
        </div>

        <div v-else>
            <tr v-for="expense in expenses" :key="expense.expenseId">
                <td>{{ expense.expenseName }}</td>
                <td>{{ expense.amount }}</td>
                <td>{{ expense.frequency }}</td>
                <td>{{ expense.dueDate }}</td>
                <td>{{ expense.category }}</td>
                <td>
                    <button @click="editToggle">Editing</button>
                </td>
                <td>
                    <button @click="deleteExpense(expense.expenseId)">Delete</button>
                </td>
            </tr>
        </div>
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
                expenseId: null,
                isEdit: !Boolean,
            };
        },

        methods: {
            async getExpenseList() { const response = await fetch("/api/expenses/expenses");
                this.expenses = await response.json();
            },

            editToggle() {
                    this.isEdit = !this.isEdit;
            },
    	    onEdit(expense){
 	            this.expenses.forEach(element => {
   	                element.isEdit= false;
   	            });
    	        expense.isEdit =true;
    	      },

            async deleteExpense(expenseId) {

                this.expenseId = expenseId;

                const deleteExpenseRequest = {
                    method: "DELETE",
                    headers: {"Content-Type": "application/json"},
                    body: JSON.stringify(this.expenseId)
                }

               try {
                    const response = await fetch("/api/expenses/delete", deleteExpenseRequest);


                    if (response.ok) {
                        this.$router.push('/expenses')

                        await this.getExpenseList();


                    } else {
                        alert("Expense deletion failed.")
                    }
                } catch (error) {
                    console.error("Error occurred during expense deletion.", error);
                }

                console.log(this.expenses.expenseId);


              }
        },
    };
</script>



