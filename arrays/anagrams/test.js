import { expect, test } from '@jest/globals';
import AnagramCalculator from './anagrams';

const allEnglishWords = [
    'apple',
    'banana',
    'orange',
    'mango',
    'blueberry',
    'peach',
    'pineapple',
    'pear',
    'kiwi',
    'pplea',
    'nanab',
    'oangm',
    'reap',
];

const anagramCalc = new AnagramCalculator(allEnglishWords);

test('finds anagrams of apple including apple and pplea', () => {
    expect(anagramCalc.getAnagrams('apple')).toEqual(['apple', 'pplea']);
});
