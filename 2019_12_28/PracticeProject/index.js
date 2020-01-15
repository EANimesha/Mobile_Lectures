/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import Robot from './components/Robots';
import MultipleGreetings from './components/MultipleGreetings';
import TextBlink from './components/TextBlink';
import TextInputs from './components/TextInputsAndButtons';
import MyScrollView from './components/MyScrollView';

AppRegistry.registerComponent(appName, () => MyScrollView);
