import React from 'react';
import { shallow } from "enzyme";
import Actor from './../components/Actor';

describe("<Actor /> component", () => {
    let wrapper, component;

    const match = {
        params : { 
                    baseId : 1 //any id you want to set
                 }
       }

    beforeEach(() => {
        wrapper = shallow(<Actor match={match}/>);
        component = wrapper.instance();
    })

    it('renders correctly', () => {
        expect(wrapper).toHaveLength(1);
        expect(wrapper).toMatchSnapshot();

    });

})


