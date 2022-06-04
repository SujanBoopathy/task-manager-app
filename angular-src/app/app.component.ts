import { Component, OnInit } from '@angular/core';
// import { timeStamp } from 'console';
import { PostService } from './services/post.service';
  
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  posts:any;
  fromDateData:any;
  t0DateData:any; 
   
  constructor(private service:PostService) {}
  
  ngOnInit() {
      this.service.getPosts()
        .subscribe(response => {
          console.log(response);
          this.posts = response;
          // console.log(this.data);
        });      
  }
  
  findEntry(system: any[]): any[] {
    return system.filter(p => p.currentTimeMillis >= this.fromDateData && p.currentTimeMillis<=this.t0DateData);
  }

  submit(from:any,to:any){
    console.log(from);
    console.log(to);
    var fDate=new Date(from);
    var tDate=new Date(to);
    this.fromDateData=fDate.getTime();
    this.t0DateData=tDate.getTime();

  }
  
  

  
}
