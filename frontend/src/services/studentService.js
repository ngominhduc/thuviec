import axios from "axios";

const STUDENT_API_BASE_url = 'http://localhost:8080/api/v1/student'

class studentService{
    getStudents(){
        axios.get("http://localhost:8080/api/v1/student").then(res =>{
            console.log(res);
        });

        return axios.get(STUDENT_API_BASE_url);
    }

    async deleteStudent(id){
        /*axios.delete("http://localhost:8080/api/v1/student/"+id).then(
            response => {
                if (response.data != null){
                    alert("student deleted");
                    this.setState({
                        students : this.state.students.filter(student => student.id !== id)
                    });
                }else {
                    this.setState({"show":false});
                }
            }
        );*/


        await axios.delete("http://localhost:8080/api/v1/student/"+id).then(response =>{
            console.log(response);
        });
    }

}
export default new studentService()