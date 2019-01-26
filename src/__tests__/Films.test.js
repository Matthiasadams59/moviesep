import React from 'react';
import { shallow } from "enzyme";
import Films from './../components/Films';

describe("<Films /> component", () => {
    let wrapper;

    beforeEach(() => {
        wrapper = shallow(<Films />);
    })

    it('renders correctly', () => {
        expect(wrapper).toHaveLength(1);
        expect(wrapper).toMatchSnapshot();
    });

    it('initializes the `state` with an empty list of films', () => {
        expect(wrapper.state().films).toEqual([]);
    });

    it('ComponentDidMount', () => {
        wrapper.instance().componentDidMount();
        expect(wrapper.state().films.length).toBe(0);
      })
})


