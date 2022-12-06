<template>
    <div>
        <router-link to="/add" class="btn btn-primary m-2" v-show="!viewForm">Add Data</router-link>
        <div class="container-fluid">
            <div class="d-flex flex-wrap" v-if="!viewForm">
              <div id="card" class="card col-lg-4 p-2"  v-for="(item ,index) in dataStudent" :key="item.id">
                <small v-show="none">{{(index + 1)}}</small>
                  <p style="font-size:larger">{{item.nama}} , {{item.umur + " "}}Years old</p>
                  <p>{{item.deskripsi_diri}}</p>
                  <table width="100%">
                      <tr>
                          <td>Email</td>
                          <td>:{{item.email}}</td>
                          <td width="5%"></td>
                          <td></td>
                      </tr>
                      <tr>
                          <td>Soft Skills</td>
                          <td>:{{item.soft_skill}}</td>
                          <td></td>
                          <td></td>
                      </tr>
                      <tr>
                          <td>Hard Skills</td>
                          <td>:{{item.hard_skill}}</td>
                          <td></td>
                          <td></td>
                      </tr>
                      <tr>
                          <td>Interest</td>
                          <td>:{{item.interest}}</td>
                          <td></td>
                          <td></td>
                      </tr>
                      <tr>
                          <td><router-link :to="{ name: 'UpdateStd', params: { id: item.id }}" class="btn btn-primary" @click.prevent="$emit('updateMuridFunc',item)">Update</router-link></td>
                          <td><button class="btn btn-danger" @click="deleteStudent(item.id)" @click.prevent="$emit('Deleted')">Delete</button></td>
                          <td></td>
                          <td><img src="../assets/male.png" v-show="item.jenis_kelamin == 'Male'" width="30px"></td>
                          <td><img src="../assets/female.png" v-show="item.jenis_kelamin == 'Female'" width="20px"></td>
                      </tr>
                  </table>
              </div>
            </div>
            <Success v-else :successVal="successVal" class="mt-5"></Success>
        </div>
    </div>
</template>

<script>
import studentService from '@/services/studentService';
import Success from './Success.vue';
export default {
    name: "InfoComponent",
    methods:{
        getData(){
            studentService.getAll()
                .then(response => {
                    this.dataStudent = response.data;
                    console.log(this.dataStudent);
                })
                .catch(e => {
                    console.log(e);
                })
        },
        deleteStudent(id){
            if(confirm("Apakah anda yakin ingin menghapus?")){
                studentService.deleteMurid(id)
                    .then(response => {
                        console.log(response.data);
                        this.viewForm = true
                        this.successVal = "Deleted"
                    
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }else{
                alert("Hapus dibatalkan!")
            }
        }
        
    },
    mounted(){
        this.getData();
    },
    data(){
        return{
            dataStudent: null,
            viewForm: false,
            successVal: "Inputed"
        }
    },
    components:{
        Success
    }
}
</script>

<style scoped>
#card {
    border: 2px solid rgb(220, 220, 220);
    border-radius: 15px;
    margin:5px ;
}
</style>