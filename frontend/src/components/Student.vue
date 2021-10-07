<template>
  <div class="container">
    <h1 class="text-center">Student List</h1>
    <table class="table table-striped">
      <thead>
      <th>Student Id</th>
      <th>Name</th>
      <th>Age</th>
      <th>DOB</th>
      <th>Email</th>
      </thead>
      <tbody>
      <tr v-for="student in students" v-bind:key="student.id">
        <td>{{ student.id }}</td>
        <td>{{ student.name }}</td>
        <td>{{ student.age }}</td>
        <td>{{ student.dob }}</td>
        <td>
          {{ student.email }}
          <button class="btn btn-primary" type="button" >add</button>
          <button class="btn btn-primary" type="button" >update</button>
          <button class="btn btn-primary" type="button" v-on:click="deleteStudent(student.id)">delete</button>
        </td>
      </tr>
      </tbody>
    </table>


  </div>
</template>

<script>
import studentService from "@/services/studentService";

  export default {
    name:'Students',
    data(){
      return{
        students : []
      }
    },
    methods:{
      getStudents(){
        studentService.getStudents().then((response) => {
          console.warn(response);
          this.students = response.data;
        });
      },

       deleteStudent(id){
        studentService.deleteStudent(id);
      }
    },
    created(){
      this.getStudents();
    },
    mounted() {
      this.getStudents();
    }
  }
</script>

<style>

</style>