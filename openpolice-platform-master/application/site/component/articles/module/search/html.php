<?php
/**
 * Nooku Framework - http://www.nooku.org
 *
 * @copyright	Copyright (C) 2011 - 2017 Johan Janssens and Timble CVBA. (http://www.timble.net)
 * @license		GNU AGPLv3 <https://www.gnu.org/licenses/agpl.html>
 * @link		https://github.com/timble/openpolice-platform
 */

use Nooku\Library;

/**
 * Search Module Html View
 *
 * @author  Arunas Mazeika <http://nooku.assembla.com/profile/arunasmazeika>
 * @package Component\Articles
 */
class ArticlesModuleSearchHtml extends PagesModuleDefaultHtml
{
    public function render()
    {
        $this->form_class   = $this->module->params->get('form_class', 'form-search');
        $this->input_class  = $this->module->params->get('input_class', 'span2 search-query');
        $this->button_class = $this->module->params->get('button_class', 'btn');
        $this->placeholder  = $this->module->params->get('placeholder', 'Search articles');
        $this->item_id      = $this->module->params->get('item_id', null);

        return parent::render();
    }
}