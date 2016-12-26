package com.hearthintellect.dao;

import com.hearthintellect.model.Card;
import com.hearthintellect.model.HeroClass;
import com.hearthintellect.model.Mechanic;
import com.hearthintellect.utils.Page;
import com.hearthintellect.utils.Sort;

import java.util.List;

public interface CardRepository extends Repository<String, Card> {

    /**
     * Find all {@code Card} that have the given name
     *
     * @param name the given name
     * @return {@code Card} that have the given name
     */
    default List<Card> findAllByName(String name) {
        return findAllByName(name, null, null);
    }

    /** Find all {@code Card} */
    default List<Card> findAll() {
        return findAll(null, null);
    }

    /**
     * <p>
     *     Find all {@code Card}, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}.
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAll(String order, Page page);

    /**
     * <p>
     *     Find all {@code Card} that have the given name, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}.
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param name the given name
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllByName(String name, String order, Page page);

    /**
     * Find all {@code Card} that belong to the given hero class
     *
     * @param heroClass the given class
     * @return {@code Card} that belong to the given hero class
     *
     * @see HeroClass
     */
    default List<Card> findAllByClass(HeroClass heroClass) {
        return findAllByClass(heroClass, null, null);
    }

    /**
     * <p>
     *     Find all {@code Card} that belong to the given hero class, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param heroClass the given hero class
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllByClass(HeroClass heroClass, String order, Page page);

    /**
     * Find all {@code Card} that belong to the given race
     *
     * @param race the given race
     * @return {@code Card} that belong to the given race
     *
     * @see Card.Race
     */
    default List<Card> findAllByRace(Card.Race race) {
        return findAllByRace(race, null, null);
    }

    /**
     * <p>
     *     Find all {@code Card} that belong to the given race, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param race the given race
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllByRace(Card.Race race, String order, Page page);

    /**
     * Find all {@code Card} that belong to the given set
     *
     * @param set the given set
     * @return {@code Card} that belong to the given set
     *
     * @see Card.Set
     */
    default List<Card> findAllBySet(Card.Set set) {
        return findAllBySet(set, null, null);
    }

    /**
     * <p>
     *     Find all {@code Card} that belong to the given set, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param set the given set
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Card.Set
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllBySet(Card.Set set, String order, Page page);

    /**
     * Find all {@code Card} that have the given quality
     *
     * @param quality the given quality
     * @return {@code Card} that have the given quality
     *
     * @see Card.Quality
     */
    default List<Card> findAllByQuality(Card.Quality quality) {
        return findAllByQuality(quality, null, null);
    }

    /**
     * <p>
     *     Find all {@code Card} that have the given quality, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param quality the given quality
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Card.Quality
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllByQuality(Card.Quality quality, String order, Page page);

    /**
     * Find all {@code Card} that have the given mechanic
     *
     * @param mechanic the given mechanic
     * @return {@code Card} that have the given mechanic
     *
     * @see Mechanic
     */
    default List<Card> findAllByMechanic(Mechanic mechanic) {
        return findAllByMechanic(mechanic, null, null);
    }

    /**
     * <p>
     *     Find all {@code Card} that have the given mechanic, and sort the result
     *     in the order designated by a given string, and return the designated page
     *     of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param mechanic the given mechanic
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Mechanic
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllByMechanic(Mechanic mechanic, String order, Page page);

    /**
     * <p>
     *     Find all {@code Card} that have the mechanic with the given ID, and sort
     *     the result in the order designated by a given string, and return the
     *     designated page of the ordered result.
     * </p>
     * <p>
     *     For the syntax of the {@code order} string, see {@link Sort#of(String)}
     * </p>
     * <p>
     *     If the given {@code order} is {@code null}, no sorting will be applied.
     * </p>
     * <p>
     *     If the given {@code page} is {@code null}, no pagination will be applied.
     * </p>
     *
     * @param mechanicId the given mechanic ID
     * @param order the given string representing a sorting order
     * @param page a {@link Page} instance describing the designated page
     * @return the designated page of the ordered result
     *
     * @see Mechanic
     * @see Page
     * @see Sort#of(String)
     */
    List<Card> findAllByMechanicId(int mechanicId, String order, Page page);
}