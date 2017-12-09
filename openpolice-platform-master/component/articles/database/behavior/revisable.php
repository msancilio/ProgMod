<?php
/**
 * Nooku Framework - http://www.nooku.org
 *
 * @copyright	Copyright (C) 2011 - 2017 Johan Janssens and Timble CVBA. (http://www.timble.net)
 * @license		GNU AGPLv3 <https://www.gnu.org/licenses/agpl.html>
 * @link		https://github.com/timble/openpolice-platform
 */

namespace Nooku\Component\Articles;

use Nooku\Library;
use Nooku\Component\Revisions;

/**
 * Revisable Database Behavior
 *
 * @author  Johan Janssens <https://github.com/johanjanssens>
 * @package Nooku\Component\Articles
 */
class DatabaseBehaviorRevisable extends Revisions\DatabaseBehaviorRevisable
{
    protected function _selectRevisions($table, $status, Library\DatabaseQueryInterface $query)
    {
        $result = parent::_selectRevisions($table, $status, $query);

        //Filter the rowset based on the category id
        if($query->params->has('categories_category_id'))
        {
            $needle = array();
            $needle['categories_category_id'] = $query->params->get('categories_category_id');

            $result = $result->find($needle);
        }

        return $result;
    }
}