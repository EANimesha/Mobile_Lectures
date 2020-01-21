/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import BasicFlatList from './components/BasicFlatList';
import HttpExample from './components/HttpExample';
import MapExample from './components/MapExample';

AppRegistry.registerComponent(appName, () => MapExample);
