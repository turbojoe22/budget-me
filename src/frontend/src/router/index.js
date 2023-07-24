import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "@/views/LoginPage.vue";
import RegisterPage from "@/views/RegisterPage.vue"
import TransactionsList from "@/views/TransactionsList.vue";
import ExpenseList from "@/views/ExpenseList.vue";
import LoginValidation from "@/components/LoginValidation.js"




const routes = [
    {
        path: "/login",
        name: "LoginPage",
        component: LoginPage,
        LoginValidation,
    },
    {
            path: "/register",
            name: "RegisterPage",
            component: RegisterPage,
//            RegisterValidation,
        },

    {
        path: "/transactions",
        name: "TransactionsList",
        component: TransactionsList,
    },
    {
        path: "/expenses",
        name: "ExpenseList",
        component: ExpenseList,
    }


];
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});
export default router;