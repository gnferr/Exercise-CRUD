<template>
  <div id="FormStudent">
    <div>
        <router-link v-show="!success" to="/" class="btn btn-primary m-2">Back</router-link>
        <div class="container border border-primary"  v-if="!success">
            <div class="d-flex justify-content-center">
                <h2>{{title}} Student</h2>
            </div>
            <form class="m-4" @submit.prevent="inputStudent">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="name">Student Name</label>
      <input v-model="dataStudent.nama" type="text" class="form-control" id="name" placeholder="Enter name" autocomplete="off" required>
    </div>
    <div class="form-group col-md-6">
      <label for="soft">Soft Skills</label>
      <input v-model="dataStudent.soft_skill" type="text" class="form-control" id="soft" placeholder="Enter Soft Skills" autocomplete="off" required>
    </div>
  </div>
  <div class="form-row">
      <div class="col">
            <label>Student Age</label>
          <input v-model="dataStudent.umur" type="number" class="form-control" placeholder="Enter Age" required>
        </div>
        <div class="col">
            <label>Gender</label>
                <select v-model="dataStudent.jenis_kelamin" class="form-control" name="gender" required>
                    <option></option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
        </div>
        <div class="col-6">
            <label>Hard Skills</label>
          <input v-model="dataStudent.hard_skill" type="text" class="form-control" placeholder="Enter hard Skills" required>
        </div>
  </div>
  <div class="form-row mt-2">
    <div class="form-group col-md-6">
      <label for="email">Student Email</label>
      <input v-model="dataStudent.email" type="email" class="form-control" id="email" placeholder="Email" autocomplete="off" required>
    </div>
    <div class="form-group col-md-6">
      <label for="interest">Interest</label>
      <select v-model="dataStudent.interest" class="form-control" name="interest" required>
            <option></option>
            <option value="Data Science">Data Sciense</option>
            <option value="Network">Network</option>
            <option value="Web Frontend">Web Frontend</option>
            <option value="Web Backend">Web Backend</option>
            <option value="Mobile Apps">Mobile Apps</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="self">Self Description</label>
    <textarea v-model="dataStudent.deskripsi_diri" name="self" class="form-control" cols="30" rows="5" placeholder="Whatever" required></textarea>
  </div>
  <button type="submit" class="btn btn-primary">{{buttonVal}}</button>
</form>
        </div>
        
        <SuccessForm v-else :successVal="successVal" class="mt-5"></SuccessForm>
    </div>
  </div>
</template>

<script>
import studentService from "../services/studentService.js";
import SuccessForm from "./Success.vue";
export default {
    name: "FormComponent",
    data(){
        return{
            dataStudent: {
                "id" : null,
                "nama" : null,
                "umur" : null,
                "email" : null,
                "hard_skill" : null,
                "soft_skill" : null,
                "interest" : null,
                "jenis_kelamin" : null,
                "deskripsi_diri" : null,
            },
            buttonVal:"Submit",
            success: false,
            successVal: "Inputed",
            title : "Add"
        }
    },
    methods: {
        inputStudent(){
            let data = this.dataStudent;
            if(this.buttonVal === "Submit"){
                studentService.create(data)
                    .then(response => {
                        console.log(response.data);
                        this.success = true;
                        this.successVal = "Inputed"
                        })
                    .catch(e => {
                        console.log(e);
                        });
            } else {
                studentService.updateMurid(data.id,data)
                    .then(response => {
                        console.log(response.data);
                        this.success = true;
                        this.successVal = "Updated"
                        })
                    .catch(e => {
                        console.log(e);
                        });
            }
        },
        getStudentId(id){
          studentService.getById(id)
                .then(response => {
                    this.dataStudent = response.data;
                    console.log(this.dataStudent);
                })
                .catch(e => {
                    console.log(e);
                })
        }
       
    },
    components: {
        SuccessForm
    },
    props : ['studentProps'],
    watch: {
        'studentProps'(iniValue){
            this.dataStudent = iniValue;
            this.buttonVal = "Update";
        }
    },
    mounted(){
      if(this.$route.name == 'UpdateStd'){
        this.getStudentId(this.$route.params.id);
        this.buttonVal = "Update";
        this.title = "Update";
      }
    }
}
</script>

<style scoped>
.container {
    padding: 2%;
}
</style>