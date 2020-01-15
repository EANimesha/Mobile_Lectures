import React,{Component} from 'react';
import {Image} from 'react-native';

export default class Robot extends Component{
    render(){
        const imageSrc={uri: "https://cdn.hswstatic.com/gif/asimo-1a.jpg"};
        return(
            <Image source={imageSrc} style={{width:200,height:400}}></Image>
        )
    }
}