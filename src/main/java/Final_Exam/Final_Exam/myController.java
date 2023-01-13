/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final_Exam.Final_Exam;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @PrasetyaAgungPrayoga - 20200140012
 */

@RestController
@RequestMapping("/surat")
@CrossOrigin
public class myController {
    Tsurat srt = new Tsurat();
    TsuratJpaController ctrl = new TsuratJpaController();
    
   List<Tsurat> srtList = new ArrayList<Tsurat>();
    
    @GetMapping()
    public List<Tsurat> viewAll(){
        try {
            return ctrl.findTsuratEntities();
        }catch (Exception e){ 
            return List.of();
        }
    }
    
    @GetMapping("/id")
    public List<Tsurat> viewDatabyId(@PathVariable("id") int id){
        try {
            srt = ctrl.findTsurat(id);
            srtList.clear();
            srtList.add(srt);
            return srtList;
            
        }catch (Exception e){
            return List.of();
        }
    }
    
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable("id")int id){
        String rslt = "Data Berhasil di Hapus!";
        try{
            ctrl.destroy(id);
        }catch (Exception e){
            rslt = "Data Gagal di Hapus!";
        }
        return rslt;
    }
    
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editData(@PathVariable("id") int id, @RequestBody Tsurat data){
        String rslt = "Data Berhasil di Update";
        try {
            data.setId(id);
            ctrl.destroy(id);
            
        }catch (Exception e) {
            rslt = "Data Gagal di Hapus";
        }
        return rslt;
    }
    
    
}
