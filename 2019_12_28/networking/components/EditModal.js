import React, { Component } from 'react';
import Modal from 'react-native-modalbox';
import {AppRegistry,FlatList,StyleSheet,Text,View,Image,Alert,TextInput, Dimensions,Button} from 'react-native';
import flatListData from '../data/flatListData';


var screen=Dimensions.get('window');
class EditModal extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             PostTitle:'',
             PostBody:''
        }
    }
    

  showEditModal=(editingPost,flatListItem)=>{
      this.setState({
          id:editingPost.id,
          title:editingPost.title,
          body:editingPost.body,
          flatListItem:flatListItem
      });
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
        <Text> Post Information</Text>
        <TextInput
            onChangeText={(text)=>this.setState({PostTitle:text})}
            placeholder="Enter post title"
            value={this.state.PostTitle}
        />
        <TextInput
            onChangeText={(text)=>this.setState({PostBody:text})}
            placeholder="Enter post body"
            value={this.state.PostBody}
        />
        <Button
        title="Save"
        onPress={()=>{
            if(this.state.PostTitle.length==0 || this.state.PostBody.length==0){
                alert("You must enter posts title and body");
                return;
            }
            var foundIndex=flatListData.findIndex(item=>this.state.id==item.id);
            if(foundIndex<0){
                return
            }
            flatListData[foundIndex].title=this.state.PostTitle;
            flatListData[foundIndex].body=this.state.PostBody;
            this.refs.myModal.close()
        }}></Button>
      </Modal>
    );
  }
}

export default EditModal;
