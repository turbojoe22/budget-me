<template>
    <div class="vue-template">

        <form>
            <h3>Log In</h3>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control form-control-lg" placeholder="username"/>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control form-control-lg" placeholder="password"/>
            </div>

            <button type="submit" class="btn btn-dark btn-lg btn-block">Sign In</button>

            <p class="register text-right mt-2 mb-4">
                <router-link to="/register">Don't have an account? Register Here!</router-link>
            </p>

        </form>
    </div>
</template>

<script>
    export default {
        data() {
            return {}
        }
    }
</script>