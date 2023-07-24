<template>
    <div class="vue-template">

        <form>
            <h3>Sign Up</h3>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control form-control-lg" placeholder="username"/>
            </div>


            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control form-control-lg" placeholder="password"/>
            </div>

            <div class="form-group">
                 <label for="verifyPassword">Verify Password</label>
                 <input type="password" class="form-control form-control-lg" />
                </div>

                <div id="error-container"></div>

            <button type="submit" class="btn btn-dark btn-lg btn-block">Sign Up</button>

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