import React, { Component } from 'react';
import Modal from 'react-native-modalbox';
import {AppRegistry,FlatList,StyleSheet,Text,View,Image,Alert,TextInput, Dimensions,Button} from 'react-native';
import flatListData from '../data/flatListData';


var screen=Dimensions.get('window');
class AddModal extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             newPostTitle:'',
             newPostBody:''
        }
    }
    

  showAddModal=()=>{
    this.refs.myModal.open();
  }
  render() {
    return (
      <Modal
      ref={"myModal"}
      style={{
          justifyContent:'center',
          shadowRadius:10,
          width:screen.width-80,
          height:280
      }}
      position='center'
      backdrop={true}
      onClosed={()=>{
          alert("modal Closed");
      }}
      >
        <Text>New Post Information</Text>
        <TextInput
            onChangeText={(text)=>this.setState({newPostTitle:text})}
            placeholder="Enter post title"
            value={this.state.newPostTitle}
        />
        <TextInput
            onChangeText={(text)=>this.setState({newPostBody:text})}
            placeholder="Enter post body"
            value={this.state.newPostBody}
        />
        <Button
        title="Save"
        onPress={()=>{
            if(this.state.newPostTitle.length==0 || this.state.newPostBody.length==0){
                alert("You must enter posts title and body");
                return;
            }
            const newPost={
                key:"",
                title:this.state.newPostTitle,
                body:this.state.newPostBody,
                image:"https://purepng.com/public/uploads/large/purepng.com-christmas-golden-bellbellchristmas-bellgolden-bellred-decorated-1421526586733f7arh.png"
            };
            flatListData.push(newPost);
            this.refs.myModal.close()
        }}></Button>
      </Modal>
    );
  }
}

export default AddModal;
