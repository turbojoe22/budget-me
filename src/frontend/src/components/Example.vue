<template>
    <h1>hello world</h1>
    <button @click="getAnswer">Go</button>
    <p>{{ answer }}</p>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
     answer: "",
    };
  } ,
  methods: {
    async getAnswer() {
      const response = await fetch("/api/getAnswer");
      const answer = await response.json();
      this.answer = answer.data;
      console.log(answer.data);
    }
  }
}
</script>


