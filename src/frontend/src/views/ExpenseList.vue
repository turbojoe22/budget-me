<template>
  <br>
  <div>
    <h2>Expense List</h2>
    <button v-if="!isHidden" v-on:click="isHidden = true" @click="getExpenseList">Display Expenses</button>
  </div>
  <table class="styled-table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Frequency</th>
            <th>Due Date</th>
            <th>Category</th>
            <th>Edit</th>
        </tr>
    </thead>

    <tbody>
        <tr v-for="expense in expenses" :key="expense.expenseId">
            <td>
                <div v-if=!isEdit>
                {{ expense.expenseName }}
                </div>
                <div v-if=isEdit>
                    <input type="text" v-model="expense.expenseName" required>
                </div>
            </td>
            <td>
                <div v-if=!isEdit>
                {{ expense.amount }}
                </div>
                <div v-if=isEdit>
                    <input type="text" v-model="expense.amount" required>
                </div>
            </td>
            <td>
                <div v-if=!isEdit>
                {{ expense.frequency }}
                </div>
                <div v-if=isEdit>
                    <input type="text" v-model="expense.frequency" required>
                </div>
            </td>
            <td>
                <div v-if=!isEdit>
                {{ expense.dueDate }}
                </div>
                <div v-if=isEdit>
                    <input type="text" v-model="expense.dueDate" required>
                </div>
            </td>
            <td>
                <div v-if=!isEdit>
                {{ expense.category }}
                </div>
                <div v-if=isEdit>
                    <input type="text" v-model="expense.category" required>
                </div>
            </td>
            <td>
                <div v-if=!isEdit>
                    <button @click="editToggle">Edit</button>
                </div>
                <div v-if=isEdit>
                    <button @click="updateExpense(expense)">Save</button>
                    <button @click="deleteExpense(expense.expenseId)">Delete</button>
                </div>
            </td>
        </tr>
    </tbody>
  </table>


  <router-link to="/expenses/create" custom v-slot="{ navigate }"><button @click="navigate" role="link">Create an Expense</button></router-link>



</template>

<style>

    table, th, td {
      border: 1px solid black;
    }
    table {
        text-align: center;
    }

    .styled-table {
        border-collapse: collapse;
        margin: 25px 0;
        font-size: 0.9em;
        font-family: sans-serif;
        min-width: 400px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }

    .styled-table thead tr {
        background-color: #009879;
        color: #ffffff;
        text-align: left;
    }

    .styled-table th,
    .styled-table td {
        padding: 12px 15px;
    }

    .styled-table tbody tr {
        border-bottom: 1px solid #dddddd;
    }

    .styled-table tbody tr:nth-of-type(even) {
        background-color: #f3f3f3;
    }

    .styled-table tbody tr:last-of-type {
        border-bottom: 2px solid #009879;
    }



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
                    category: ''
                },
                isHidden: false,
                expenses: null,
                expenseId: null,
                isEdit: false,
            };
        },

        methods: {
            editToggle() {

                if (this.isEdit) {
                    this.isEdit = false;
                } else {
                    this.isEdit = true;
                }
            },

            onEdit(expense){
                this.expenses.forEach(element => {
                    element.isEdit= false;
                });
                expense.isEdit =true;
            },

            async getExpenseList() { const response = await fetch("/api/expenses/expenses");
                this.expenses = await response.json();
            },

            async updateExpense(expense) {
                this.expense = expense;

                const updateExpenseRequest = {
                    method: "PUT",
                    headers: {"Content-Type": "application/json"},
                    body: JSON.stringify(this.expense)
                }

               try {
                    const response = await fetch("/api/expenses/update", updateExpenseRequest);

                    if (response.ok) {
                        this.isEdit = false;
                        await this.getExpenseList();
                        this.$router.push('/expenses')
                    } else {
                        alert("Expense update failed.")
                    }
                } catch (error) {
                    console.error("Error occurred during expense update.", error);
                }

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
                        this.isEdit = false;
                        await this.getExpenseList();
                        this.$router.push('/expenses')
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



