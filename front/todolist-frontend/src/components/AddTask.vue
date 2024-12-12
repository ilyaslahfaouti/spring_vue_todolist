<template>
    <div>
      <input v-model="taskName" placeholder="Ajouter une tâche" />
      <button @click="addTask">Ajouter</button>
    </div>
  </template>
  
  <script>
  import api from '@/services/api';
  
  export default {
    data() {
      return {
        taskName: '',
      };
    },
    methods: {
      async addTask() {
        if (!this.taskName) return;
  
        try {
          await api.post('/tasks', {
            name: this.taskName,
            status: 'en cours',
          });
          this.$emit('taskAdded');
          this.taskName = '';
        } catch (error) {
          console.error('Erreur lors de l\'ajout de la tâche:', error);
        }
      },
    },
  };
  </script>
  