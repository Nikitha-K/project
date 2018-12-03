# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.test import TestCase

# Create your tests here.
from django.test import TestCase
from django.urls import resolve
from django.core.urlresolvers import reverse

from .views import Board_Topics,home1,new_topic
from .models import Board

class Home_Test(TestCase):
    def setUp(self):
        self.board=Board.objects.create(name="django",description="django board")
        url=reverse("home1")
        self.response=self.client.get(url)


    def test_home_view_status_code(self):
        self.assertEquals(self.response.status_code, 200)
    def test_home_view_status_code(self):
        view=resolve('/')
        self.assertEquals(view.func,home1)
    def test_home_view_contains_link_to_topics_page(self):
        board_topics_url=reverse("Board_Topic",kwargs={"pk":self.board.pk})
        self.assertContains(self.response,'href="{0}"'.format(board_topics_url))


class BoardTopicsTests(TestCase):
    def setUp(self):
        Board.objects.create(name="django",description="django board")

    def test_board_topics_view_success_status_code(self):
        url = reverse("Board_Topic", kwargs={"pk": 1})
        response = self.client.get(url)
        self.assertEquals(response.status_code, 200)

    def test_board_topics_view_not_found_status_code(self):
        url = reverse("Board_Topic", kwargs={"pk": 99})
        response = self.client.get(url)
        self.assertEquals(response.status_code, 404)

    def test_board_topics_url_resolves_board_topics_view(self):
        view = resolve("/boards/1/")
        self.assertEquals(view.func, Board_Topics)

    def test_board_topics_view_contains_link_back_to_homepage(self):
        board_topics_url = reverse("Board_Topic", kwargs={"pk":1})
        response=self.client.get(board_topics_url)
        homepage_url=reverse("home1")
        self.assertContains(response,"href='{0}'".format(homepage_url))

class NewTopicTests(TestCase):
    def setUp(self):
        Board.objects.create(name="django",description="django board")

    def test_new_topic_view_success_status_code(self):
        url=reverse("new_topic",kwargs={"pk":1})
        response=self.client.get(url)
        self.assertEquals(response.status_code,200)
    def test_new_topic_view_not_found_status_code(self):
        url=reverse("new_topic",kwargs={"pk":99})
        response=self.client.get(url)
        self.assertEquals(response.status_code,404)
    def test_new_topic_url_resolves_new_topic_view(self):
        view=resolve('/boards/1/new/')
        self.assertEquals(view.func,new_topic)
    def test_new_topic_view_contains_link_back_to_board_topics_view(self):
        new_topic_url=reverse("new_topic",kwargs={"pk":1})
        response=self.client.get(new_topic_url)
        board_topic_url=reverse("Board_Topic",kwargs={"pk":1})
        self.assertContains(response,"href='{0}'".format(board_topic_url))


