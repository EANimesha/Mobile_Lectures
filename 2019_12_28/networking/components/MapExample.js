import React, { Component } from 'react';
import MapView,{PROVIDER_GOOGLE} from 'react-native-maps';
import {StyleSheet} from 'react-native';

export class MapExample extends Component {
    render() {
        return (
            <MapView
            provider={PROVIDER_GOOGLE}
            style={styles.container}
            region={{
                latitude: 42.882004,
                longitude: 74.582748,
                latitudeDelta: 0.0922,
                longitudeDelta: 0.0421
            }}
            // showsUserLocation={true}
            />
        )
    }
}
const styles=StyleSheet.create({
    container:{
        height:'100%',
        width:'100%'
    }
})
export default MapExample
