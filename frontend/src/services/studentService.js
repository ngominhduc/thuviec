import axios from "axios";

const STUDENT_API_BASE_url = 'http://localhost:8080/api/v1/student'

class studentService {
    getStudents() {
        axios.get(STUDENT_API_BASE_url).then(res => {
            console.log(res);
        });

        return axios.get(STUDENT_API_BASE_url);
    }

    deleteStudent(id) {
        axios.delete(STUDENT_API_BASE_url + "/" + id).then(
            response => {
                if (response.data != null) {
                    alert("student deleted");
                }
            }
        );

        /*
        await axios.delete("http://localhost:8080/api/v1/student/"+id).then(response =>{
            console.log(response);
        });
         */
    }

}

export default new studentService()