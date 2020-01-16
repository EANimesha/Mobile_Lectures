import React, { Component } from 'react';
import {AppRegistry, FlatList, StyleSheet,Text,View,Image, Alert, TouchableHighlight} from 'react-native';
import flatListData from '../data/flatListData';
import Swipeout from 'react-native-swipeout';
import AddModal from './AddModel';

class FlatListItem extends Component{
    constructor(props) {
        super(props);
        this.state = {
             activeRowId:null
        } 
    }
    
    render(){
        const swipeSettings={
            autoClose:true,
            onClose:(secId,rowId,direction)=>{
                if(this.state.activeRowId!=null){
                    this.setState({activeRowId:null});
                }
            },
            onOpen:(secId,rowId,direction)=>{
                this.setState({activeRowId:this.props.item.id});
            },
            right:[
                {
                    onPress:()=>{
                        const deletingRow=this.state.activeRowId;
                        Alert.alert(
                            'Alert',
                            'Are You sure you want to delete? ',
                            [
                                {text:'No',onPress:()=>console.log('cancel pressed'),style:'cancel'},
                                {text:'Yes',onPress:()=>{
                                    flatListData.splice(this.props.index,1);
                                    this.props.parentFlatList.refreshFlatList(deletingRow);
                                }}
                            ],
                            {cancelable:true}
                        );
                    },
                    text:'Delete',type:'delete'
                }
            ],
            rowId:this.props.index,
            sectionId:1
        };
        return(
            <Swipeout {...swipeSettings}>
            <View style={{
                flex:1,
                flexDirection:'row',
                backgroundColor:this.props.index % 2 ==0? 'green':'tomato'
            }}>
            <Image
                source={{uri:this.props.item.image}}
                style={{width:100,height:100,margin:5}}
            />

            <View style={{
                flex:1,
                flexDirection:'column'
            }}>
            <Text style={styles.flatListItem} style={{color:'black'}}>{this.props.item.title.toString()}</Text>
            <Text style={styles.flatListItem}>{this.props.item.body.toString()}</Text> 
            </View>
            </View>
            </Swipeout>
        )
    }
}

const styles=StyleSheet.create({
    flatListItem:{
        color:'white',
        padding:10,
        fontSize:16
    }
})

export class BasicFlatList extends Component {
    constructor(props) {
        super(props);
        this.state=({
            deleteRowKey:null
        })
        this._onPressAdd=this._onPressAdd.bind(this);
    }
    
    refreshFlatList=(deleteKey)=>{
        this.setState({
            deleteRowKey:deleteKey
        });
    }
    _onPressAdd(){
        // alert('You add item')
        this.refs.addModal.showAddModal()
    }
    render() {
        return (
            <View style={{flex:1,marginTop:22}}>
            {/* <Text>My FlatList</Text> */}
            <TouchableHighlight
                underlayColor='tomato'
                onPress={this._onPressAdd}
            >
                <Text>Add Item</Text>
            </TouchableHighlight>
                <FlatList
                data={flatListData}
                renderItem={({item,index})=>
                // {
                    // console.log(`Item= ${item},index= ${index}`);
                    <FlatListItem item={item} index={index} parentFlatList={this}>

                    </FlatListItem>
                // }
                }
                keyExtractor={ (item, index) => index.toString() }
                >

                </FlatList>
                <AddModal
                ref={'addModal'} parentFlatList={this}></AddModal>
            </View>
        )
    }
}

export default BasicFlatList;
 