<template>
    <div>
      <h1>Ma To-Do List</h1>
      <ul>
        <li v-for="task in tasks" :key="task.id">
          {{ task.name }} - {{ task.status }}
        </li>
      </ul>
      <AddTask @taskAdded="fetchTasks"/>
    </div>
  </template>
  
  <script>
  import api from '@/services/api';
  import AddTask from './AddTask.vue';
  
  export default {
    components: {
      AddTask
    },
    data() {
      return {
        tasks: [],
      };
    },
    created() {
      this.fetchTasks();
    },
    methods: {
      async fetchTasks() {
        try {
          const response = await api.get('/tasks');
          this.tasks = response.data;
        } catch (error) {
          console.error('Erreur lors de la récupération des tâches:', error);
        }
      },
    },
  };
  </script>
  