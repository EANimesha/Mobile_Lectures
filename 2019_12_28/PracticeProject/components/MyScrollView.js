import React, { Component } from 'react'
import { ScrollView,Image,View, Dimensions,Text } from 'react-native'

export class MyScrollView extends Component {
    render() {
        let screenWidth=Dimensions.get('window').width;
        return (
            // <ScrollView>
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            //     <Image source={require('../assets/images/pic.jpg')}
            //         style={{width:420,height:200,marginTop:20}}
            //     />
            // </ScrollView>
            <ScrollView
            horizontal={true}
            pagingEnabled={true}
            showsHorizontalScrollIndicator={true}>
                <View style={{
                    backgroundColor:'#5f9ea0',
                    flex:1,
                    width:screenWidth,
                    marginTop:20,
                    justifyContent:'center',
                    alignItem:'center'
                }}>
                <Text
                style={{
                    fontSize:20,
                    color:'white',textAlign:'center'
                }}>Screen1</Text>
                </View>

                <View style={{
                    backgroundColor:'#ff7800',
                    flex:1,
                    width:screenWidth,
                    marginTop:20,
                    justifyContent:'center',
                    alignItem:'center'
                }}>
                <Text
                style={{
                    fontSize:20,
                    color:'white',textAlign:'center'
                }}>Screen2</Text>
                </View>

                <View style={{
                    backgroundColor:'#5f9ea0',
                    flex:1,
                    width:screenWidth,
                    marginTop:20,
                    justifyContent:'center',
                    alignItem:'center'
                }}>
                <Text
                style={{
                    fontSize:20,
                    color:'white',textAlign:'center'
                }}>Screen3</Text>
                </View>

                <View style={{
                    backgroundColor:'#890034',
                    flex:1,
                    width:screenWidth,
                    marginTop:20,
                    justifyContent:'center',
                    alignItem:'center'
                }}>
                <Text
                style={{
                    fontSize:20,
                    color:'white',textAlign:'center'
                }}>Screen4</Text>
                </View>
            </ScrollView>
        )
    }
}

export default MyScrollView
